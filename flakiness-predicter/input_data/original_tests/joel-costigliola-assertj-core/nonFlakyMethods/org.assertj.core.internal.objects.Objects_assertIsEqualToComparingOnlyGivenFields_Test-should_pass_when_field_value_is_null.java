@Test public void should_pass_when_field_value_is_null(){
  Jedi actual=new Jedi("Yoda",null);
  Jedi other=new Jedi("Yoda",null);
  objects.assertIsEqualToComparingOnlyGivenFields(someInfo(),actual,other,"name","lightSaberColor");
}
