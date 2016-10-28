package com.freeland.domain.json.statistics;

import lombok.Data;

/**
 * Created by hanxiao on 2016/9/18.
 */
@Data
public class Distribution {

    public String province;

    public String city;

    public double latitude;

    public double longtitude;

    public int count;

}
