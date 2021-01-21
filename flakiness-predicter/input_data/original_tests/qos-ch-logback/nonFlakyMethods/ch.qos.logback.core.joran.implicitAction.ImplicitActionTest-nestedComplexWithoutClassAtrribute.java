@Test public void nestedComplexWithoutClassAtrribute() throws Exception {
  try {
    simpleConfigurator.doConfigure(IMPLCIT_DIR + "nestedComplexWithoutClassAtrribute.xml");
    verifyFruit();
  }
 catch (  Exception je) {
    StatusPrinter.print(fruitContext);
    throw je;
  }
}
