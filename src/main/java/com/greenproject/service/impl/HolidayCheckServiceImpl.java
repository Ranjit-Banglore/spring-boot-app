package com.greenproject.service.impl;

import com.greenproject.model.HolidayCheck;
import com.greenproject.repository.HolidayCheckRepository;
import com.greenproject.service.HolidayCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HolidayCheckServiceImpl implements HolidayCheckService {

    private HolidayCheckRepository holidayCheckRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    private List<Set<String>> checks=new ArrayList<>();

    @Override
    public List<Set<String>> getChecks() {
        return checks;
    }

    @Override
    public void initialiseChecks(){
        Set<String> name= new HashSet<>();
        Set<String> country=new HashSet<>();
        Set<String> region=new HashSet<>();
        Set<String> city=new HashSet<>();

           listAll().forEach(holidayCheck -> {
               name.add(holidayCheck.getName().trim().toLowerCase());
               country.add(holidayCheck.getStadt().trim().toLowerCase());
               region.add(holidayCheck.getRegion().trim().toLowerCase());
               city.add(holidayCheck.getLand().trim().toLowerCase());
           });

           checks.add(0,name);
           checks.add(1,country);
           checks.add(2,region);
           checks.add(3,city);
    }

    @Autowired
    public HolidayCheckServiceImpl(HolidayCheckRepository holidayCheckRepository) {
        this.holidayCheckRepository = holidayCheckRepository;
    }

    public HolidayCheckServiceImpl() {
    }

    @Override
    public List<HolidayCheck> listAll() {
        List<HolidayCheck> holidayChecks = new ArrayList<>();
        holidayCheckRepository.findAll().forEach(holidayChecks::add);
        return holidayChecks;
    }

    public void create() {
        try {
            List<HolidayCheck> list = new ArrayList<>();
            Resource resource = resourceLoader.getResource("classpath:HolidayCheckEuropaData.csv");
            File file = resource.getFile();
            BufferedReader csvReader = new BufferedReader(new FileReader(file));
            //ignoring first row of csv file
            String row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(";");
                if (!data[0].isEmpty()) {
                    list.add(transform(data));
                }
            }
            holidayCheckRepository.saveAll(list);
            csvReader.close();
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    private HolidayCheck transform(String[] data) {
        HolidayCheck holidayCheck = new HolidayCheck();
        if (data.length > 0) holidayCheck.setLink(data[0]);
        if (data.length > 1) holidayCheck.setName(data[1]);
        if (data.length > 2) holidayCheck.setAdresse(data[2]);
        if (data.length > 3) holidayCheck.setMail(data[3]);
        if (data.length > 4) holidayCheck.setTelefon(data[4]);
        if (data.length > 5) holidayCheck.setStadt(data[5]);
        if (data.length > 6) holidayCheck.setRegion(data[6]);
        if (data.length > 7) holidayCheck.setLand(data[7]);
        if (data.length > 8) holidayCheck.setKontinent(data[8]);
        if (data.length > 9) holidayCheck.setHotelbew(data[9]);
        if (data.length > 10) holidayCheck.setZimmerbew(data[10]);
        if (data.length > 11) holidayCheck.setServicebew(data[11]);
        if (data.length > 12) holidayCheck.setLagebew(data[12]);
        if (data.length > 13) holidayCheck.setGatronomiebew(data[13]);
        if (data.length > 14) holidayCheck.setSportAndUnterhaltungbew(data[14]);
        if (data.length > 15) holidayCheck.setBewAnzahl(data[15]);
        if (data.length > 16) holidayCheck.setWeiterempfehlung(data[16]);
        if (data.length > 17) holidayCheck.setGesamtbewertung(data[17]);
        if (data.length > 18) holidayCheck.setSterne(data[18]);
        if (data.length > 19) holidayCheck.setAward(data[19]);
        if (data.length > 20) holidayCheck.setPosition(data[20]);
        if (data.length > 21) holidayCheck.setZimmerausstattung(data[21]);
        if (data.length > 22) holidayCheck.setAktivitaeten(data[22]);
        if (data.length > 23) holidayCheck.setUmgebung(data[23]);
        if (data.length > 24) holidayCheck.setGastronomie(data[24]);
        if (data.length > 25) holidayCheck.setAusstattung(data[25]);
        if (data.length > 26) holidayCheck.setSterne(data[26]);
        return holidayCheck;
    }
}
