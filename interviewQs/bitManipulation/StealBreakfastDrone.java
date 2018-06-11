/**
1 ^ 1  →  0
1 ^ 0  →  1
0 ^ 1  →  1
0 ^ 0  →  0
We start with a variable uniqueDeliveryId set to 0. 
Every time we XOR with a new ID, it will change the bits. 
When we XOR with the same ID again, it will cancel out the earlier change.
*/

public StealBreakfastDrone{
	public static int findUniqueDeliveryId(int[] deliveryIds) {

	    int uniqueDeliveryId = 0;

	    for (int deliveryId: deliveryIds) {
	        uniqueDeliveryId ^= deliveryId;
	    }

	    return uniqueDeliveryId;
	}
	
}