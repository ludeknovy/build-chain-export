package org.jetbrains.teamcity.buildChainExport.controllers;

import javax.servlet.http.HttpServletRequest;
import jetbrains.buildServer.web.openapi.PagePlaces;
import jetbrains.buildServer.web.openapi.PlaceId;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.SimplePageExtension;
import jetbrains.buildServer.web.util.WebUtil;
import org.jetbrains.annotations.NotNull;

public class BuildTypeExtension extends SimplePageExtension {
  public BuildTypeExtension(@NotNull PagePlaces pagePlaces, @NotNull PluginDescriptor pluginDescriptor) {
    super(pagePlaces);
    setIncludeUrl(pluginDescriptor.getPluginResourcesPath("buildType.jsp"));
    // TODO use constant when TeamCity 2021.1 is released
    setPlaceId(new PlaceId("BUILD_CONF_ACTIONS"));
    setPluginName(pluginDescriptor.getPluginName());
    register();
  }

  @Override
  public boolean isAvailable(@NotNull final HttpServletRequest request) {
    return super.isAvailable(request) && WebUtil.getPathWithoutContext(request).startsWith("/viewType.html");
  }
}
