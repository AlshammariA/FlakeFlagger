@Test public void should_pass_even_if_non_accepted_fields_differ(){
  Jedi actual=new Jedi("Yoda","Green");
  Jedi other=new Jedi("Yoda","Blue");
  objects.assertIsEqualToComparingOnlyGivenFields(someInfo(),actual,other,"name");
}
