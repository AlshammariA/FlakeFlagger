@Test public void should_pass_when_private_fields_differ_but_are_not_compared_or_are_ignored(){
  boolean allowedToUsePrivateFields=FieldSupport.comparison().isAllowedToUsePrivateFields();
  Assertions.setAllowComparingPrivateFields(false);
  TestClassWithRandomId actual=new TestClassWithRandomId("1",1);
  TestClassWithRandomId other=new TestClassWithRandomId("1",2);
  objects.assertIsEqualToIgnoringGivenFields(someInfo(),actual,other,"n");
  Assertions.setAllowComparingPrivateFields(allowedToUsePrivateFields);
}
