@SuppressWarnings("unchecked") @Test public void should_pass_if_actual_contains_given_entries_in_order() throws Exception {
  maps.assertContainsExactly(someInfo(),linkedActual,entry("name","Yoda"),entry("color","green"));
}
