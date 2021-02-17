import ptolemy . plot . * ;
public class MergeSort {
    int countArray ;
    public void sort(int arr[], int left, int right){
        if(left < right){
            //Encuentra el punto medio del vector.
            int middle = (left + right) / 2;
            //Divide la primera y segunda mitad (llamada recursiva).
            sort(arr, left, middle);
            sort(arr, middle +1, right);
            //Une las mitades.
            merge(arr, left, middle, right);
        }
    }

    public void merge(int arr[], int left, int middle, int right) {
        //Encuentra el tamaño de los sub-vectores para unirlos.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        //Vectores temporales.
        int leftArray[] = new int [n1];
        int rightArray[] = new int [n2];

        //Copia los datos a los arrays temporales.
        for (int i=0; i < n1; i++) {
            leftArray[i] = arr[left+i];


        }
        for (int j=0; j < n2; j++) {
            rightArray[j] = arr[middle + j + 1];
        }
        /* Une los vectorestemporales. */

//Índices inicial del primer y segundo sub-vector.
        int i = 0, j = 0;

//Índice inicial del sub-vector arr[].
        int k = left;

//Ordenamiento.
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
                //countArray = i;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;

        }//Fin del while.

        /* Si quedan elementos por ordenar */
//Copiar los elementos restantes de leftArray[].
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
            countArray = k;
        }
//Copiar los elementos restantes de rightArray[].
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i) {
            System.out.println(arr[i] + "Original ");
        }
        System.out.println();
    }

    public void graficMergeSort(int arr[]) {

        System.out.println(arr + "Original ");
            System.out.println("count"+ countArray + "cantidad de veces ");

        Plot plotObj = new Plot () ;
                // setting data
                        series(null, Plot.data().
                        xy(1, 2).
                        xy(3, 4), null);

// saving sample_minimal.png
        plot.save("sample_minimal", "png");
    }

}