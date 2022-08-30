import proguard.AppView;
import proguard.ClassPath;
import proguard.ClassPathEntry;
import proguard.Configuration;
import proguard.InputReader;
import proguard.OutputWriter;
import proguard.classfile.ClassPool;

import java.io.File;
import java.io.IOException;

public class TestRun {

    public static void main(String[] args) throws IOException {

        File inputFile = new File("/home/pramitha/Downloads/apprelease.apk");
        File outputFile = new File("/home/pramitha/Downloads/DexOut/output/out.apk");
        File libraryFile = new File("/home/pramitha/Android/Sdk/platforms/android-33/android.jar");


        ClassPath programFilePaths = new ClassPath();
        ClassPath libraryClassPaths = new ClassPath();

        programFilePaths.add(new ClassPathEntry(inputFile, false));
        programFilePaths.add(new ClassPathEntry(outputFile, true));
        libraryClassPaths.add(new ClassPathEntry(libraryFile, false));

        ClassPool programClassPool = new ClassPool();
        ClassPool libraryClassPool = new ClassPool();

        Configuration configuration = new Configuration();
        configuration.programJars = programFilePaths;
        configuration.libraryJars = libraryClassPaths;
        configuration.android = true;
        configuration.dalvik = true;
        configuration.preverify = false;
        configuration.ignoreWarnings = true;

        AppView appView = new AppView();
        appView.programClassPool = programClassPool;
        appView.libraryClassPool = libraryClassPool;

        new InputReader(configuration)
                .execute(appView);

//        libraryClassPool.classesAccept(new ClassPrinter());
//        programClassPool.classesAccept(new ClassPrinter());

        new OutputWriter(configuration)
                .execute(appView);

////         Create the writer for the main file or directory.
//        DataEntryWriter writer = outputDex.isFile() ? new FixedFileWriter(outputDex) : new DirectoryWriter(outputDex);
//
////         A dex file can't contain resource files.
//        writer =
//                new FilteredDataEntryWriter(
//                        new DataEntryNameFilter(
//                                new ExtensionMatcher("dex")),
//                        writer);
//
//
//        writer = new DexDataEntryWriter(2, programClassPool, "test_classes.dex", true, writer, writer);
//
//        programClassPool.classesAccept(
//                new DataEntryClassWriter(writer));
//
//        writer.close();

    }
}