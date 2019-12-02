package cn.tblack.bookstack.converter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String,Date>{

	@Override
	public Date convert(String source) {
		
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
			
		sdf.setLenient(false); //不设置为宽松解析。 需要严格进行匹配
		try {
			
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
