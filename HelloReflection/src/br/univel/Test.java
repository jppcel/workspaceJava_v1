package br.univel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public Test(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<?> cl = obj.getClass();
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO");
		sb.append(cl.getSimpleName().toUpperCase()).append(" (");
		Field[] vetorFields = cl.getDeclaredFields();
		
		//for(Field field : vetorFields){
		int qtdFileds = vetorFields.length;
		for(int i = 0; i < qtdFileds;i++){
			Field filed = vetorFields[i];
			//System.out.println(field.getName() + "" + field.getType());
			sb.append(filed.getName());
			if(i < qtdFileds -1){
				sb.append(", ");
			}
		}
		sb.append(")VALUE(");
		String sql = sb.toString();
		System.out.println(sql);
		
		//for(Method m : cl.getDeclaredMethods()){
		//	if(m.getName().startsWith("get")){
		//	Object retorno = m.invoke(obj, null);
		//		System.out.println(retorno);
		//	}
		//}
	}
	
	public static void main(String[] args){
		Pessoa p = new Pessoa();
		
		p.setId(1);
		p.setNome("Jhonatan");
		
		try {
			new Test(p);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
