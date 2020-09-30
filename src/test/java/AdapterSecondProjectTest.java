import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.contentEquals;

public class AdapterSecondProjectTest {
    private static final String TARGET_TEST_RESOURCES_PATH = "target/test-classes/";

    @Test(description = "")
    public void adapterTest() throws IOException {
        String targetOutputFilePath = TARGET_TEST_RESOURCES_PATH + "output.txt";
        new Adapter().sumMatrices(
                new File(TARGET_TEST_RESOURCES_PATH + "expectedGeneratedMatrices.txt"),
                new File(targetOutputFilePath)
        );
        Assert.assertTrue(contentEquals(
                new File(targetOutputFilePath),
                new File(TARGET_TEST_RESOURCES_PATH + "expectedAdapterResult.txt")
        ));
    }
}
