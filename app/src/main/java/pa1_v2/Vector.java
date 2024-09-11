package pa1_v2;

/**
 * Vector class represents a vector in n-dimensional space with basic operations.
 */
public class Vector {

    // Attributes
    private int n;
    private int[] data;

    /**
     * Constructor to initialize the Vector with the specified number of 
     * dimensions (n) and sets all elements to -1.
     * @param n The number of dimensions of the vector.
     */
    public Vector(int n) {
        this.n = n;
        this.data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = -1;
        }
    }

    /**
     * Get the number of dimensions of the vector.
     * @return The number of dimensions.
     */
    public int getDimension() {
        return this.n;
    }

    /**
     * Get the element at the specified index in the vector.
     * @param index The index of the element.
     * @return The element at the specified index.
     */
    public int read(int index) {
        return this.data[index];
        
    }   

    /**
     * Set the element at the specified index in the vector to the given value.
     * @param index
     * @param value
     */
    public void update(int index, int value) {
        this.data[index] = value;
    }

    /**
     * Remove the element at the specified index in the vector.
     * @param index The index of the element to remove.
     */
    public void delete(int index) {
       /**new list and append all old to new except deleted value*/
        for (int i=index; i<n-1; i++){
            this.data[i] = this.data[i+1];
        }
        this.data[n-1] = -1;
    }

    /**
     * Add the elements of the given vector v to the current vector.
     * The vectors must have the same number of dimensions.
     * @param v The vector to add.
     */
    public void add(Vector v) {
            for (int i = 0; i < n; i++) {
                this.data[i]  += v.data[i];
                }

        }

    /**
     * Subtract the elements of the given vector v from the current vector.
     * @param v
     */
    public void subtract(Vector v) {
            for (int i = 0; i < n; i++) {
                 this.data[i] -= v.data[i];
                }
            }

    /**
     * Get the maximum element in the vector.
     * @return The maximum element.
     */
    public int max() {
        int max;
        max = this.data[0];
        for (int i = 0; i < n; i++) {
            if (this.data[i]>max){
                max = this.data[i];
                }
            }
        return max;
        }       

    /**
     * Get the minimum element in the vector.
     * @return The minimum element.
     */
    public int min(){
        int min;
        min = this.data[0];
        for (int i = 0; i < n; i++) {
            if (this.data[i]<min){
                min = this.data[i];
                }
            }
        return min;
    }
    /**
     * Get the average of all elements in the vector.
     * @return The average of all elements.
     */
    public double average() {
        int avg;
        avg = 0;
        for (int i = 0; i < n; i++) {
            avg += this.data[i];
            }
        avg = avg/n;
        return avg;
    }

    /**
     * Search for the first occurrence of the specified value in the vector.
     * @param value The value to search for.
     * @return The index of the first occurrence of the value, or -1 if not found.
     */
    public int search(int value) {
        int ind;
        ind = -1;
        for (int i = 0; i < n; i++) {
            if (this.data[i]==value){
                ind = i;
            }
            }
        return ind;
    }

    /**
     * Search for the first occurrence of the specified value in the vector.
     * This method is optimized for speed using the Binary Search Algorithm.
     * @param value The value to search for.
     * @return The index of the first occurrence of the value, or -1 if not found.
     */
    public int searchFast(int value){
        int ind;
        ind = -1;
        int mid;
        mid = Math.round(this.n/2);
        int start;
        start = 0;
        int end; 
        end = this.n;
        if (this.data[mid]==value){
            ind = mid;
            start=end;
        }
        if(this.data[start]==value){
            ind = start;
            start=end;
        }
        if (this.data[end]==value){
            ind = end;
            start=end;
        }
        else{
            while(start!=end){
            if (this.data[mid]>value){
                end = mid;
                mid = Math.round(mid/2);}
            else if(this.data[mid]<value){
                start = mid;
                mid = Math.round((end-mid)/2);
            }
            else if(value == this.data[mid]){
                start=end;
                ind=mid;
            }
            }
            }
            return ind;
    }


    /**
     * Sort the elements of the vector in ascending order.
     */
    public void sort() {
       for (int i=0; i<this.n; i++){
            int min = this.data[i];
            int min_ind = i;
            for (int j=i; j<this.n; j++){
                if (min > this.data[j]){
                    min = this.data[j];
                    min_ind = j;
                }
            }
            int temp = this.data[i];
            this.data[i] = this.data[min_ind];
            this.data[min_ind] = temp;
       }
    }
    
}
