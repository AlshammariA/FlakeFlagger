@Test public void should_fail_when_some_field_value_is_null_on_one_object_only(){
  AssertionInfo info=someInfo();
  Jedi actual=new Jedi("Yoda",null);
  Jedi other=new Jedi("Yoda","Green");
  try {
    objects.assertIsEqualToIgnoringGivenFields(info,actual,other,"name");
  }
 catch (  AssertionError err) {
    List<Object> expected=newArrayList((Object)"Green");
    verify(failures).failure(info,shouldBeEqualToIgnoringGivenFields(actual,newArrayList("lightSaberColor"),newArrayList((Object)null),expected,newArrayList("name")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
