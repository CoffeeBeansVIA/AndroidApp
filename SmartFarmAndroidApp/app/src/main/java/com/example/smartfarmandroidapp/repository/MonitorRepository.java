package com.example.smartfarmandroidapp.repository;

import com.example.smartfarmandroidapp.view.MonitorActivity;

public class MonitorRepository extends MonitorActivity {

    public void getCO2(){
       super.getCO2API();
    }
//    @Inject
//    public void getCO2() {
//        CO2API co2API = FarmServiceGenerator.getCO2API();
//        Call<CO2> call = co2API.getCO2(3);
//        call.enqueue(new Callback<CO2>() {
//            @EverythingIsNonNull
//            @Override
//            public void onResponse(Call<CO2> call, Response<CO2> response) {
//                if (response.isSuccessful()) {
//                    CO2Event event = new CO2Event();
//                    event.setCO2(response.body().getValue()+"");
//                    EventBus.getDefault().post(event);
//                }
//            }
//
//            @EverythingIsNonNull
//            @Override
//            public void onFailure(Call<CO2> call, Throwable t) {
//                t.printStackTrace();
//            }
//
//        });
//    }
//    @Inject
//    public void getHumidity(){
//        HumidityAPI humidityAPI = FarmServiceGenerator.getHumidityAPI();
//        Call<Humidity> call = humidityAPI.getHumidity(2);
//        call.enqueue(new Callback<Humidity>() {
//            @Override
//            public void onResponse(Call<Humidity> call, Response<Humidity> response) {
//                if(response.isSuccessful())
//                {
//                    HumidityEvent event = new HumidityEvent();
//                    event.setHumidity(response.body().getValue()+"");
//                    EventBus.getDefault().post(event);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Humidity> call, Throwable t) {
//
//            }
//        });
//    }
//    @Inject
//    public void getTemperature(){
//        TemperatureAPI temperatureAPI = FarmServiceGenerator.getTemperatureAPI();
//        Call<Temperature> call = temperatureAPI.getTemperature(1);
//        call.enqueue(new Callback<Temperature>() {
//            @Override
//            public void onResponse(Call<Temperature> call, Response<Temperature> response) {
//                if(response.isSuccessful())
//                {
//                    TemperatureEvent event = new TemperatureEvent();
//                    event.setTemperature(response.body().getValue()+"");
//                    EventBus.getDefault().post(event);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Temperature> call, Throwable t) {
//
//            }
//        });
//    }
}
