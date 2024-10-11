package at.htlhl.demoapp.data

import java.security.MessageDigest

data class User(
    private var userName: String,
    private var firstName: String,
    private var lastName: String,
    private var email: String,
    private var phone: String,
    private var pwHash: String,
) {

    constructor() : this("", "", "", "", "", "")

    fun getUserName(): String {
        return this.userName
    }

    fun getFirstName(): String {
        return this.firstName
    }

    fun getLastName(): String {
        return this.lastName
    }

    fun getEmail(): String {
        return this.email
    }

    fun getPhone(): String {
        return this.phone
    }

    fun getPwHash(): String {
        return this.pwHash
    }

    fun setUserName(value: String) {
        this.userName = value
    }

    fun setFirstName(value: String) {
        this.firstName = value
    }

    fun setLastName(value: String) {
        this.lastName = value
    }

    fun setEmail(value: String) {
        this.email = value
    }

    fun setPhone(value: String) {
        this.phone = value
    }

    fun setPwHash(value: String) {
        this.pwHash = hashSHA256(value)
    }

    fun hashSHA256(text: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val byteArray = text.toByteArray()
        digest.update(byteArray)
        val hashBytes = digest.digest()
        return hashBytes.joinToString("") { "%02x".format(it) }
    }

}
