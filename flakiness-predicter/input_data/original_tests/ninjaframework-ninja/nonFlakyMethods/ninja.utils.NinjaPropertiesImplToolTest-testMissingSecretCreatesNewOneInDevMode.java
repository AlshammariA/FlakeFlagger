@Test public void testMissingSecretCreatesNewOneInDevMode() throws Exception {
  String uuid=UUID.randomUUID().toString();
  String baseDirWithoutTrailingSlash="/tmp/ninja-test-" + uuid;
  String devConf=baseDirWithoutTrailingSlash + File.separator + "src/main/java/conf/application.conf";
  PropertiesConfiguration defaultConfiguration=new PropertiesConfiguration();
  defaultConfiguration.setFileName(devConf);
  Configuration compositeConfiguration=new PropertiesConfiguration();
  boolean isProd=false;
  NinjaPropertiesImplTool.checkThatApplicationSecretIsSet(isProd,baseDirWithoutTrailingSlash,defaultConfiguration,compositeConfiguration);
  assertTrue(compositeConfiguration.getString(NinjaConstant.applicationSecret).length() == 64);
  assertTrue(defaultConfiguration.getString(NinjaConstant.applicationSecret).length() == 64);
  assertTrue(Files.toString(new File(devConf),Charsets.UTF_8).contains(NinjaConstant.applicationSecret));
  FileUtils.deleteDirectory(new File(baseDirWithoutTrailingSlash));
}
