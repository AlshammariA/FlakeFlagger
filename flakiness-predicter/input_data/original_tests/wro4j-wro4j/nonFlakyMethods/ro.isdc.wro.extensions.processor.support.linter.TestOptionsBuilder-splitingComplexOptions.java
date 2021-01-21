@Test public void splitingComplexOptions(){
  final String option="option1,option2,option3=['YUI','window','document','xui'],option4,option5=['YUI','xui'],option6";
  final String[] result=optionsBuilder.splitOptions(option);
  assertEquals(6,result.length);
  assertEquals(Arrays.toString(new String[]{"option1","option2","option3=['YUI','window','document','xui']","option4","option5=['YUI','xui']","option6"}),Arrays.toString(result));
}
