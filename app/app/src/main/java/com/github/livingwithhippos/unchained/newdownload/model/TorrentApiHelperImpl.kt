package com.github.livingwithhippos.unchained.newdownload.model

import okhttp3.RequestBody
import retrofit2.Response
import javax.inject.Inject

class TorrentApiHelperImpl @Inject constructor(private val torrentsApi: TorrentsApi) :
    TorrentApiHelper {
    override suspend fun getAvailableHosts(token: String): Response<List<AvailableHost>> =
        torrentsApi.getAvailableHosts(token)

    override suspend fun addTorrent(
        token: String,
        binaryTorrent: RequestBody,
        host: String
    ): Response<UploadedTorrent> = torrentsApi.addTorrent(token, binaryTorrent, host)

    override suspend fun getTorrentsList(
        token: String,
        offset: Int?,
        page: Int?,
        limit: Int?,
        filter: String?
    ): Response<List<TorrentItem>> = torrentsApi.getTorrentsList(token, offset, page, limit, filter)

    override suspend fun selectFiles(token: String, id: String, files: String) =
        torrentsApi.selectFiles(token, id, files)
}