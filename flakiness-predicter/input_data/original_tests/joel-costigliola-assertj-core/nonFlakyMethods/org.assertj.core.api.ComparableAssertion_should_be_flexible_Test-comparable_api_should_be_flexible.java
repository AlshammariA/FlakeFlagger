@Test public void comparable_api_should_be_flexible(){
  TestClass testClass1=new TestClass();
  TestClass testClass2=new TestClass();
  TestClassAssert.assertThat(testClass1).isEqualByComparingTo(testClass2);
}
