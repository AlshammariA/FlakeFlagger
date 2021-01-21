@Test public void should_report_all_errors() throws Throwable {
  try {
    softly.assertThat(1).isEqualTo(1);
    softly.assertThat(1).isEqualTo(2);
    softly.assertThat(Lists.newArrayList(1,2)).containsOnly(1,3);
    MultipleFailureException.assertEmpty(softly.getErrors());
    fail("Should not reach here");
  }
 catch (  MultipleFailureException e) {
    List<Throwable> failures=e.getFailures();
    assertThat(failures).hasSize(2).extracting("message").contains("expected:<[2]> but was:<[1]>","\n" + "Expecting:\n" + "  <[1, 2]>\n"+ "to contain only:\n"+ "  <[1, 3]>\n"+ "elements not found:\n"+ "  <[3]>\n"+ "and elements not expected:\n"+ "  <[2]>\n");
  }
}
