package br.univel;

import br.univel.anotacoes.Tabela;

public class LerAnotacao {
	
	public LerAnotacao(Object obj){ //Passo 1
		Class<?> cl = obj.getClass();
		
		if(cl.isAnnotationPresent(Tabela.class)){
			//System.out.println("ta presente !");
			Tabela t = cl.getAnnotation(Tabela.class);
			System.out.println(t.value());
		}//else{
		//System.out.println("Nao ta presente !");
		//}
	}
	
	public static void main(String[] args){
		
		Pessoa p = new Pessoa();
		p.setId(1);
		p.setNome("Bruce Wayne");
		
		new LerAnotacao(p);
	}
}
