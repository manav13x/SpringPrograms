package com.verizon.jhd.model.O2MM2O;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Participants")
public class Participant implements Comparable<Participant> {

		@Id
		private int pin;
		private String name;
		
		@ManyToOne
		@JoinColumn(name="ccode")
		private Course course;
		
		public Participant() {
			
		}

		public Participant(int pin, String name, Course course) {
			super();
			this.pin = pin;
			this.name = name;
			this.course = course;
		}

		public int getPin() {
			return pin;
		}

		public void setPin(int pin) {
			this.pin = pin;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}

		@Override
		public int compareTo(Participant o) {
			Integer pin1=this.pin;
			Integer pin2=o.pin;
			return pin1.compareTo(pin2);
		}
}
