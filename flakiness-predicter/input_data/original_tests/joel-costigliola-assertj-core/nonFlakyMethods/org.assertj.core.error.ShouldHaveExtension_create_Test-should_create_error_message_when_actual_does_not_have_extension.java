@Test public void should_create_error_message_when_actual_does_not_have_extension() throws Exception {
  assertThat(createMessage(null)).isEqualTo(String.format("[TEST] %n" + "Expecting%n" + "  <" + actual + ">%n"+ "to have extension:%n"+ "  <\""+ expectedExtension+ "\">%n"+ "but had no extension."));
}
