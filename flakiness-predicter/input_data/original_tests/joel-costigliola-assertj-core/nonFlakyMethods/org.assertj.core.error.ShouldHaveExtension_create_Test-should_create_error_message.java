@Test public void should_create_error_message() throws Exception {
  assertThat(createMessage("png")).isEqualTo(String.format("[TEST] %n" + "Expecting%n" + "  <" + actual + ">%n"+ "to have extension:%n"+ "  <\""+ expectedExtension+ "\">%n"+ "but had:%n"+ "  <\"png\">."));
}
