package question10;

public class Bruteforce {
	static class PetrolDetails{
		int petrol;
		int distance;
		
		public PetrolDetails(int petrol,int distance){
			this.petrol=petrol;
			this.distance=distance;
		}
	}
	
	static int findStartingPump(PetrolDetails[] data) {
		int n=data.length;
		int start = 0; 
        int end = 1; 
        int petrolAvailable = data[start].petrol - data[start].distance; 
          
        // If current amount of petrol in truck becomes less than 0, then 
        // remove the starting petrol pump from tour 
        while(end != start || petrolAvailable < 0) 
        { 
              
            // If current amount of petrol in truck becomes less than 0, then 
            // remove the starting petrol pump from tour 
            while(petrolAvailable < 0 && start != end) 
            {
                // Remove starting petrol pump. Change start 
            	petrolAvailable = (data[start].petrol - data[start].distance)-petrolAvailable; 
                start = (start + 1) % n; 
                  
                // If 0 is being considered as start again, then there is no 
                // possible solution 
                if(start == 0) 
                    return -1; 
            } 
            // Add a petrol pump to current tour 
            petrolAvailable = (data[end].petrol - data[end].distance)+petrolAvailable; 
              
            end = (end + 1)%n; 
        } 
          
        // Return starting point 
        return start;
	}
	
	public static void main(String args[]) {
		PetrolDetails data[]= {
				new PetrolDetails(4,6),
				new PetrolDetails(6,5),
				new PetrolDetails(7,3),
				new PetrolDetails(4,5),
		};
		
		System.out.println(findStartingPump(data)+1);
	}
}