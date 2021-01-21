/** 
 * Tests a known issue with JsMin.
 */
@Test(expected=WroRuntimeException.class) public void shoudlFailWhenCompilingAnExpressionWithNewLines() throws Exception {
  processor.process(null,new StringReader("Math.round(4\n/3);"),new StringWriter());
}
