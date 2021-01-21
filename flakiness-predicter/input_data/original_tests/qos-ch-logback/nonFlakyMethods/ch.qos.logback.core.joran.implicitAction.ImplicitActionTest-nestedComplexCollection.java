@Test public void nestedComplexCollection() throws Exception {
  try {
    simpleConfigurator.doConfigure(IMPLCIT_DIR + "nestedComplexCollection.xml");
    verifyFruitList();
  }
 catch (  Exception je) {
    StatusPrinter.print(fruitContext);
    throw je;
  }
}
