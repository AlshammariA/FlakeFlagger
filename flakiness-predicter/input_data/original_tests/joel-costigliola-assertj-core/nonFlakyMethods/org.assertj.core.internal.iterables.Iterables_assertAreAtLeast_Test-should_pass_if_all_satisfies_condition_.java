@Test public void should_pass_if_all_satisfies_condition_(){
  actual=newArrayList("Yoda","Luke","Obiwan");
  iterables.assertAreAtLeast(someInfo(),actual,2,jedi);
  verify(conditions).assertIsNotNull(jedi);
}
