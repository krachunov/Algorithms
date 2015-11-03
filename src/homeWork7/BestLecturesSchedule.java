/**
 * Problem 4. Best Lectures Schedule
A long time ago in a neighborhood far, far away SoftUni used to have just one lecture hall.
Let’s have a list of lectures, each having a start time s and a finish time f (s and f will be positive integers).
Obviously, only one lecture can be presented at a time, they cannot overlap. Write a program that maximizes the number of lectures presented. 
Lectures will be given in format name: start – finish. Assume the name will contain only word characters (letters, digits and '_'). 
 */
package homeWork7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BestLecturesSchedule {

	static class Lecture {
		private String lectureName;
		private int startTime;
		private int finishTime;

		public Lecture(String name, int star, int finish) {
			setLectureName(name);
			setStartTime(star);
			setFinishTime(finish);
		}

		public String getLectureName() {
			return lectureName;
		}

		public void setLectureName(String lectureName) {
			this.lectureName = lectureName;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getFinishTime() {
			return finishTime;
		}

		public void setFinishTime(int finishTime) {
			this.finishTime = finishTime;
		}

		@Override
		public String toString() {
			return getStartTime() + "-" + getFinishTime() + "-> "
					+ getLectureName();
		}

	}

	static List<Lecture> bestProgramLecture(List<Lecture> lectures) {
		List<Lecture> program = new ArrayList<Lecture>();
		lectures.sort(new Comparator<Lecture>() {

			@Override
			public int compare(Lecture o1, Lecture o2) {
				return (o1.getFinishTime() > o2.getFinishTime() ? 1 : o1
						.getFinishTime() < o2.getFinishTime() ? -1 : 0);
			}
		});

		Lecture lastlecture = lectures.get(0);
		program.add(lastlecture);
		for (Lecture lecture : lectures) {
			if (lecture.getStartTime() >= lastlecture.getFinishTime()) {
				program.add(lecture);
				lastlecture = lecture;
			}
		}
		return program;
	}

	public static void main(String[] args) {
		List<Lecture> lectures = new ArrayList<>();
		lectures.add(new Lecture("Java", 1, 7));
		lectures.add(new Lecture("OOP", 3, 13));
		lectures.add(new Lecture("C-Programing", 5, 9));
		lectures.add(new Lecture("Advanced_JavaScript", 10, 14));

		List<Lecture> lectures2 = new ArrayList<>();
		lectures2.add(new Lecture("Advanced_CSharp", 3, 8));
		lectures2.add(new Lecture("High_Quality_Code", 7, 10));
		lectures2.add(new Lecture("Databases", 5, 12));
		lectures2.add(new Lecture("ASP_NET", 9, 14));
		lectures2.add(new Lecture("Angular_JS", 13, 15));
		lectures2.add(new Lecture("Algorithms", 15, 19));
		lectures2.add(new Lecture("Programming_Basics", 17, 20));

		List<Lecture> programs = bestProgramLecture(lectures2);

		for (Lecture lecture : programs) {
			System.out.println(lecture.toString());
		}
	}
}
