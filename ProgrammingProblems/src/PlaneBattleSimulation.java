import java.util.ArrayList;

public class PlaneBattleSimulation {
	public static void main(String args[]) {
		String[] commands = {"addPlane puppy 0 0", "addPlane wolf 0 0", "accelerate puppy 1 1", "updatePlanes", "updatePlanes", "fire puppy 1 1"};
		String[] output = solution(commands);
		
		for(String o : output) {
			System.out.println(o);
		}
	}
	
	public static String[] solution(String[] commands) {
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
							}
						}
					}
				}
			} else if(parts[0].equals("updatePlanes")) {
				for(Plane p : planes) {
					p.update();
				}
			}
		}
		String[] output = new String[planes.size()];
		for(int i = 0; i < planes.size(); i++) {
			output[i] = planes.get(i).toString();
		}
		return output;
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
			
			return (0 == (yo-yf)/(xo-xf)*(x-xf) + yf - y) && correctX && correctY;
		}
		
		public String toString() {
			return name + " " + x + " " + y;
		}
	}
}
