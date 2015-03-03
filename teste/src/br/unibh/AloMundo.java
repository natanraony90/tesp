package br.unibh;

import java.math.BigDecimal;
import java.util.Date;

public class AloMundo {

	public static void main(String[] args) {

		/*for (int i = 0; i < 10; i++) {
			System.out.println(i + 1 + " - Alô Mundo");
		}*/
		
		Aluno a1 = new Aluno(1234L, "João", "98798798799", new Date());
		Aluno a2 = new Aluno(4321L, "Maria", "98798798799", new Date());
		Aluno a3 = new Aluno(1245L, "Julia", "1234456690");
		Aluno a4 = new Aluno(3214L, "Natã");
		Professor p1 = new Professor("Pedro", "12312312345", new BigDecimal(12000));
		Professor p2 = new Professor("Gabriel", "1237654829");
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(p1);
		System.out.println(p2);
			

	}
}
