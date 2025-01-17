/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.netty.v4.common.internal.client;

import io.opentelemetry.instrumentation.api.instrumenter.network.NetworkAttributesGetter;
import io.opentelemetry.instrumentation.netty.v4.common.internal.ChannelUtil;
import java.net.InetSocketAddress;
import javax.annotation.Nullable;

final class NettySslNetAttributesGetter implements NetworkAttributesGetter<NettySslRequest, Void> {

  @Override
  public String getNetworkTransport(NettySslRequest request, @Nullable Void unused) {
    return ChannelUtil.getNetworkTransport(request.channel());
  }

  @Nullable
  @Override
  public InetSocketAddress getNetworkPeerInetSocketAddress(
      NettySslRequest request, @Nullable Void unused) {
    if (request.remoteAddress() instanceof InetSocketAddress) {
      return (InetSocketAddress) request.remoteAddress();
    }
    return null;
  }
}
