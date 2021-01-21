@Test public void should_fail_when_some_inherited_field_values_differ(){
  AssertionInfo info=someInfo();
  Jedi actual=new Jedi("Yoda","Green");
  Jedi other=new Jedi("Luke","Green");
  try {
    objects.assertIsEqualToComparingOnlyGivenFields(info,actual,other,"name","lightSaberColor");
  }
 catch (  AssertionError err) {
    List<Object> expected=newArrayList((Object)"Luke");
    List<Object> rejected=newArrayList((Object)"Yoda");
    verify(failures).failure(info,shouldBeEqualComparingOnlyGivenFields(actual,newArrayList("name"),rejected,expected,newArrayList("name","lightSaberColor")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
