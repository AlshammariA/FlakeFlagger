@Test public void should_pass_if_actual_contains_only_expected_entries() throws Exception {
  maps.assertContainsOnlyKeys(someInfo(),actual,"color","name");
}
