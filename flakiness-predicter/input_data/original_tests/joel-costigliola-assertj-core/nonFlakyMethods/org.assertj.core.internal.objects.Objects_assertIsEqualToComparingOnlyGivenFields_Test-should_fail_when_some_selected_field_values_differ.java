@Test public void should_fail_when_some_selected_field_values_differ(){
  AssertionInfo info=someInfo();
  Jedi actual=new Jedi("Yoda","Green");
  Jedi other=new Jedi("Yoda","Blue");
  try {
    objects.assertIsEqualToComparingOnlyGivenFields(info,actual,other,"name","lightSaberColor");
  }
 catch (  AssertionError err) {
    List<Object> expected=newArrayList((Object)"Blue");
    List<Object> rejected=newArrayList((Object)"Green");
    verify(failures).failure(info,shouldBeEqualComparingOnlyGivenFields(actual,newArrayList("lightSaberColor"),rejected,expected,newArrayList("name","lightSaberColor")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
