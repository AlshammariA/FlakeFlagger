@Test public void testMinimizeAttributeIsFalseOnResource() throws Exception {
  new GenericTestBuilder().processAndCompare("/resourceMinimizeFalse.js","classpath:ro/isdc/wro/manager/sample.js");
}
