@Test public void should_fail_if_actual_has_same_type_as_other(){
  AssertionInfo info=someInfo();
  try {
    objects.assertDoesNotHaveSameClassAs(info,actual,new Person("Luke"));
    failBecauseExpectedAssertionErrorWasNotThrown();
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldNotHaveSameClass(actual,new Person("Luke")));
  }
}
