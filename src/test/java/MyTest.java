import java.util.zip.DeflaterOutputStream;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: PACKAGE_NAME
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-23  13:53
 * @Description: TODO
 * @Version: 1.0
 */

public class MyTest {

    public static void main(String[] args) {

        int[] dp = new int[3];
        for (int j = 0; j < 3; j++) {
            int prev1 = dp[(j + 1) % 3];
            int prev2 = dp[(j + 2) % 3];
            System.out.println(j);
            System.out.println((j + 1) % 3);
            System.out.println((j + 2) % 3);
        }
    }
}
