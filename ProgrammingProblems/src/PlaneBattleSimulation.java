import java.util.ArrayList;
import java.util.Scanner;

public class PlaneBattleSimulation {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] commands = new String[n];
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			commands[i] = sc.nextLine();
		}
		
		solution(commands);
		
		
	}
	
	public static void solution(String[] commands) {
		ArrayList<Plane> planes = new ArrayList<Plane>();
		for(int i = 0; i < commands.length; i++) {
			String[] parts = commands[i].split(" ");
			if(parts[0].equals("addPlane")) {
				planes.add(new Plane(parts[1],Integer.parseInt(parts[2]),Integer.parseInt(parts[3])));
			} else if (parts[0].equals("accelerate")) {
				for(Plane p : planes) {
					if(p.name.equals(parts[1])) {
						p.accelerate(Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
					}
				}
			} else if (parts[0].equals("fire")) {
				for(int j = 0; j< planes.size(); j++) {
					if(planes.get(j).name.equals(parts[1])) {
						for(int k = 0; k < planes.size(); k++) {
							int xo = planes.get(j).x;
							int yo = planes.get(j).y;
							int xf = Integer.parseInt(parts[2]) + planes.get(j).x;
							int yf = Integer.parseInt(parts[3]) + planes.get(j).y;
							if(planes.get(k).checkShot(xo, yo, xf, yf) && !planes.get(k).name.equals(parts[1])) {
								planes.remove(k);
								k--;
								j--;
							}
						}
					}
				}
			} else if(parts[0].equals("updatePlanes")) {
				for(Plane p : planes) {
					p.update();
				}
				printPlanes(planes);
			}
		}
		
	}
	
	
	public static void printPlanes(ArrayList<Plane> planes) {
		String[] output = new String[planes.size()];
		for(int i = 0; i < planes.size(); i++) {
			output[i] = planes.get(i).toString();
		}
		for(String o : output) {
			System.out.println(o);
		}
	}
	
	private static class Plane {
		int x;
		int y;
		String name;
		int velX;
		int velY;
		
		public Plane(String name, int x, int y) {
			this.name = name;
			this.x = x;
			this.y = y;
		}
		
		public void accelerate(int x, int y) {
			velX += x;
			velY += y;
		}
		
		public void update() {
			x += velX;
			y += velY;
		}
		
		public boolean checkShot(int xo, int yo, int xf, int yf) {
			boolean correctX = true;
			boolean correctY = true;
			
			if(xf > xo && x < xo) {
				correctX = false;
			}
			if(xf < xo &&  x > xo) {
				correctX = false;
			}
			if(yf > yo && y < yo) {
				correctY = false;
			}
			if(yf < yo && y > yo) {
				correctY = false;
			}
			
			/*if((xo-xf) == 0) {
				return (0 == Math.abs(yf-y)+Math.abs(yo-y)) && correctY;
			}*/
			
			return ((xo-xf)*(y-yf) == (yo-yf)*(x-xf)) && correctX && correctY;
		}
		
		public String toString() {
			return name + " " + x + " " + y;
		}
	}
}
