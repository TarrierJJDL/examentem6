import java.util.Scanner;

import org.hibernate.Session;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado=new Scanner(System.in);
		int n; String t,u,i;
		
		
		Session session = HibernataUtilities.getSessionFactory().openSession();
		do {
			
		System.out.println("1- Para intro empresa 2-Para intro item 3-Para intro pedido");
		System.out.println("4- Para mostrar empresa 5-Para mostrar item 6-Para mostrar pedido");
		System.out.println("0- Para salir");
			n=teclado.nextInt();
		
			
		if (n==1) {
			session.beginTransaction();
			System.out.println("Nombre:");
			t=teclado.toString();
			System.out.println("Lugar:");
			u=teclado.toString();
			System.out.println("Fecha:");
			i=teclado.toString();
			
			festival e = new festival();
			e.setNombre(t);
			e.setLugar(u);
			e.setFecha(i);
			
			session.save(e);
			
			session.getTransaction().commit();
				
			
			
		}
		if(n==4) {	
		
		session.beginTransaction();
		System.out.println("Nombre del grupo:");
		t=teclado.toString();
		festival e = session.get(festival.class, t);
		System.out.println("Hemos recuperado "+e.getNombre()+" "+
		e.getLugar()+" "+e.getFecha());
		
		session.getTransaction().commit();
		
		
		
		}
		if (n==2) {
			session.beginTransaction();
			System.out.println("Hora:");
			t=teclado.toString();
			System.out.println("Escenario:");
			u=teclado.toString();
			
			
			actuacion e = new actuacion();
			e.setHora(t);
			e.setEscenario(u);
			
			
			session.save(e);
			
			session.getTransaction().commit();
				
			
			
		}
		if(n==5) {	
		
			session.beginTransaction();
			System.out.println("Escenario:");
			t=teclado.toString();
			actuacion e = session.get(actuacion.class, t);
			System.out.println("Hemos recuperado "+e.getEscenario()+" "+
			e.getHora());
			
			session.getTransaction().commit();
			
		
		
		}
		if (n==3) {
			session.beginTransaction();
			System.out.println("Nombre:");
			t=teclado.toString();
			System.out.println("Estilo:");
			u=teclado.toString();
			System.out.println("Miembros:");
			i=teclado.toString();
			
			
			grupo e = new grupo();
			e.setNombre(t);
			e.setEstilo(u);
			e.setNumero(i);
			
			session.save(e);
			
			session.getTransaction().commit();
				


			
		}
		if(n==6) {	
		
			session.beginTransaction();
			System.out.println("Nombre del grupo:");
			t=teclado.toString();
			grupo e = session.get(grupo.class, t);
			System.out.println("Hemos recuperado "+e.getNombre()+" "+
			e.getEstilo()+" "+e.getNumero());
			
			session.getTransaction().commit();
		
		
		
		}
		}while(n!=0);
		session.close();
		HibernataUtilities.getSessionFactory().close();

	}

}
