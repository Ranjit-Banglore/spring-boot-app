package com.greenproject.service.impl;

import com.greenproject.enumeration.Partner;
import com.greenproject.model.Product;
import com.greenproject.repository.ProductRepository;
import com.greenproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductServiceImpl() {
    }

    @Override
    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product saveOrUpdate(Product product) {
       /* if(productRepository.existsById(product.getId())){
            productRepository.deleteById(product.getId());
        }*/
        return productRepository.save(product);
    }

    @Override
    public void create(Product product) {
         productRepository.save(product);
    }

    @Override
    public void addAll() {
        productRepository.saveAll(getAllProducts());
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    private List<Product> getAllProducts(){
        List<Product> products=new ArrayList<>();
        for (Partner partner : Partner.getPartners()) {
            try {
                processPartnerData(partner, products);
            } catch (Exception ex) {
                System.out.println(String.format("Error in processing partner: %s", partner));
            }
        }

        return products;
    }

    private void processPartnerData(Partner partner, List<Product> products) throws Exception {
        final String location = "https://productdata.awin.com/datafeed/download/apikey/8716383058ae2c46ae4dd36a08628015/language/de/fid/" + partner.getId() + "/columns/aw_deep_link,product_name,aw_product_id,merchant_product_id,merchant_image_url,description,merchant_category,search_price,merchant_name,merchant_id,category_name,category_id,aw_image_url,currency,store_price,delivery_cost,merchant_deep_link,language,last_updated,display_price,data_feed_id,brand_name,brand_id,colour,product_short_description,specifications,condition,product_model,model_number,dimensions,keywords,promotional_text,product_type,commission_group,merchant_product_category_path,merchant_product_second_category,merchant_product_third_category,rrp_price,saving,savings_percent,base_price,base_price_amount,base_price_text,product_price_old,delivery_restrictions,delivery_weight,warranty,terms_of_contract,delivery_time,in_stock,stock_quantity,valid_from,valid_to,is_for_sale,web_offer,pre_order,stock_status,size_stock_status,size_stock_amount,merchant_thumb_url,large_image,alternate_image,aw_thumb_url,alternate_image_two,alternate_image_three,alternate_image_four,reviews,average_rating,rating,number_available,custom_1,custom_2,custom_3,custom_4,custom_5,custom_6,custom_7,custom_8,custom_9,ean,isbn,upc,mpn,parent_product_id,product_GTIN,basket_link,Travel%3Alocation,Travel%3Acheck_in_date,Travel%3Acheck_in_time,Travel%3Acheck_out_date,Travel%3Aduration,Travel%3Aguests_per_room,Travel%3Ahotel_name,Travel%3Ahotel_address,Travel%3Ahotel_stars,Travel%3Ahotel_features,Travel%3Achild_policy,Travel%3Aroom_type,Travel%3Aroom_description,Travel%3Aavailability,Travel%3Aboard_basis,Travel%3Alongitude,Travel%3Alatitude,Travel%3Adeparture_code,Travel%3Aarrival_code,Travel%3Adeparture_date,Travel%3Areturn_date,Travel%3Ainbound_duration,Travel%3Astarting_from_price,Travel%3Acheck_out_time,Travel%3Aticket_type,Travel%3Acancellation_policy,Travel%3Aroom_amenities,Travel%3Adestination_name,Travel%3Adestination_address,Travel%3Adestination_zipcode,Travel%3Adestination_city,Travel%3Adestination_region,Travel%3Adestination_country,Travel%3Adestination_coordinates,Travel%3Adestination_type,Travel%3Atravel_rating,Travel%3Atravel_transport,Travel%3Atravel_pax_min,Travel%3Atravel_pax_max,Travel%3Atravel_type,Travel%3Aprice_per_person/format/xml-tree/compression/gzip/adultcontent/1/";
        URL url = new URL(location);
        URLConnection conn = url.openConnection();
        conn.setAllowUserInteraction(false);
        GZIPInputStream ginstream = new GZIPInputStream(conn.getInputStream());
        BufferedReader buffer = new BufferedReader(new InputStreamReader(ginstream));
        String rowXml;
        int count = 0;
        while ((rowXml = buffer.readLine()) != null) {
            if (rowXml.contains("<product>")) {
                count++;
                products.add(convertToProduct(rowXml));
            }

        }
        System.out.println(String.format("Partner: %s,  Data processed: %d", partner.getName(), count));
    }

    private Product convertToProduct(String xml){
        Product product=new Product();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            product=  (Product) jaxbUnmarshaller.unmarshal(new StringReader(xml));
            System.out.println(product);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return product;
    }

}
