@Test public void splitingComplexOption(){
  final String option="predef=['YUI','window','document','OnlineOpinion','xui']";
  final String[] result=optionsBuilder.splitOptions(option);
  assertEquals(1,result.length);
  assertTrue(Arrays.equals(new String[]{option},result));
}
