package br.com.calendarevents.parsers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import android.content.Context;
import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;
import br.com.calendarevents.beans.Pessoa;

public class XmlParse {
	
	private static Pessoa pessoa;
	private static ArrayList<Pessoa> arrayPessoa;
	private static InputStream is;
	private static String versao;
	
	 public static ArrayList<Pessoa> parse(Context context) throws IOException, SAXException {
	       
	        final RootElement root = new RootElement("root");
	        
	        arrayPessoa = new ArrayList<Pessoa>();
	        is = context.getResources().getAssets().open("xml.xml");
	        
	        // use setStartElementListener para ter acesso aos atributos do item atual 
	        root.setStartElementListener(new StartElementListener() {				
				@Override
				public void start(Attributes attrb) {
					versao = attrb.getValue("versao");
				}
			});
	        
	        //pega referência de um item 
	        Element item = root.getChild("item");
	        
	        //agora vamos pegar todos os valores que estão dentro do item
	        //sempre inicie com esse método no item
	        item.setStartElementListener(new StartElementListener() {
				
				@Override
				public void start(Attributes attr) {
					//aproveite e instancie aqui um novo objeto para armazar as informações desse item
					pessoa = new Pessoa();
					pessoa.setVersao(versao);
				}
			});
	        
	        item.getChild("nome").setEndTextElementListener(new EndTextElementListener(){
	            public void end(String nome) {
	                pessoa.setNome(nome);
	            }
	        });
	        item.getChild("idade").setEndTextElementListener(new EndTextElementListener(){
	            public void end(String idade) {
	            	pessoa.setIdade(Integer.valueOf(idade));
	            }
	        });
	        
	        //quando os itens acabarem, chame esse método e adicione a instancia atual de Pessoo no ArrayList
	        item.setEndElementListener(new EndElementListener() {
				
				@Override
				public void end() {
					arrayPessoa.add(pessoa);
				}
			});
	        
            Xml.parse(is, Xml.Encoding.UTF_8, root.getContentHandler());
            
	        return  arrayPessoa;
	    }

}
