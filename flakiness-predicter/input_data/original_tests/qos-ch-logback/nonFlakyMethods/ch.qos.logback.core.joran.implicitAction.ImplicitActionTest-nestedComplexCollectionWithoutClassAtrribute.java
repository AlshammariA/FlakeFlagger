@Test public void nestedComplexCollectionWithoutClassAtrribute() throws Exception {
  try {
    simpleConfigurator.doConfigure(IMPLCIT_DIR + "nestedComplexCollectionWithoutClassAtrribute.xml");
    verifyFruitList();
  }
 catch (  Exception je) {
    StatusPrinter.print(fruitContext);
    throw je;
  }
}
