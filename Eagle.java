import sun.awt.X11.Depth;

public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    public void takeOff(){
        if (!this.flying && this.altitude ==0) {
            this.flying = true;
        System.out.printf("%s take off in the sky.%n", this.getName());
        }
    }

    /**
     * fly upward
     * @param meters altitudes increase
     * @return altitude
     */

    @Override
    public int ascend(int meters) {
       if (this.flying) {
           this.altitude = Math.min(this.altitude + meters, 325);
           System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.altitude);
       }
       return this.altitude;
    }

     /**
     * fly downward
     * @param meters altitudes decrease
     * @return altitude
     */
    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    @Override
    public void glide() {
            System.out.printf("It glides into the air.%n");
        }

    @Override
    public void land() {
        if (this.flying && this.altitude == 10) {
            System.out.printf("%s is too high, it can't lands.%n", this.getName());
        } else {
            System.out.printf("%s lands on the ground.%n", this.getName());
        } 
    }
}