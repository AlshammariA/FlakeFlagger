@Test public void installAndUninstallWithCommonDependencies() throws Exception {
  File alpha=createTemporaryFile("alpha.jar");
  File bravo=createTemporaryFile("bravo.jar");
  File charlie=createTemporaryFile("charlie.jar");
  given(this.resolver.resolve(Arrays.asList("bravo"))).willReturn(Arrays.asList(bravo,alpha));
  given(this.resolver.resolve(Arrays.asList("charlie"))).willReturn(Arrays.asList(charlie,alpha));
  this.installer.install(Arrays.asList("bravo"));
  assertThat(getNamesOfFilesInLib(),containsInAnyOrder("alpha.jar","bravo.jar",".installed"));
  this.installer.install(Arrays.asList("charlie"));
  assertThat(getNamesOfFilesInLib(),containsInAnyOrder("alpha.jar","bravo.jar","charlie.jar",".installed"));
  this.installer.uninstall(Arrays.asList("bravo"));
  assertThat(getNamesOfFilesInLib(),containsInAnyOrder("alpha.jar","charlie.jar",".installed"));
  this.installer.uninstall(Arrays.asList("charlie"));
  assertThat(getNamesOfFilesInLib(),containsInAnyOrder(".installed"));
}
