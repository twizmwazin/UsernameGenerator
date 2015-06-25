package me.electroid.nicknamer;

public class CommandLineMain {

    public static void main(String... args) {
        MinecraftNameGenerator gen = new MinecraftNameGenerator(GeneratorUtil.MIN_USERNAME_LENGTH);
        System.out.println(gen.generate(GeneratorUtil.getSeedFromOcn()));
    }

}
