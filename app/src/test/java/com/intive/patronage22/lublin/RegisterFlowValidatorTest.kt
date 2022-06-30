package com.intive.patronage22.lublin

import android.content.Context
import org.amshove.kluent.`should be`
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.never
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class RegisterFlowValidatorTest {

    private lateinit var registerClass: RegisterFlowValidator
    private var context: Context = mock()

    @Before
    fun setUp() {
        registerClass = RegisterFlowValidator(context)
    }

    @Test
    fun `given empty user name when validateUsername then request text from resources by proper resource id`() {
        val emptyUserName = ""
        whenever(context.getString(R.string.not_valid_username_error)).doReturn("Enter a valid name")

        registerClass.validateUsername(emptyUserName)

        verify(context).getString(R.string.not_valid_username_error)
    }

    @Test
    fun `given empty user name when validateUsername then return proper message`() {
        val emptyUserName = ""
        whenever(context.getString(R.string.not_valid_username_error)).doReturn("Enter a valid name")

        val result = registerClass.validateUsername(emptyUserName)

        result `should be` "Enter a valid name"
    }

    @Test
    fun `given special characters username when validateUsername then request text from resources by proper resource id`() {
        val specialCharacterString = "@#$"
        whenever(context.getString(R.string.not_valid_username_error)).doReturn("Enter a valid name")

        registerClass.validateUsername(specialCharacterString)

        verify(context).getString(R.string.not_valid_username_error)
    }

    @Test
    fun `given special characters username when validateUsername then return proper message`() {
        val specialCharacterString = "@#$"
        whenever(context.getString(R.string.not_valid_username_error)).doReturn("Enter a valid name")

        val result = registerClass.validateUsername(specialCharacterString)

        result `should be` "Enter a valid name"
    }

    @Test
    fun `given polish characters username when validateUsername then request text from resources by proper resource id`() {
        val polishCharacterString = "śĆĄŚĘ"
        whenever(context.getString(R.string.not_valid_username_error)).doReturn("Enter a valid name")

        registerClass.validateUsername(polishCharacterString)

        verify(context).getString(R.string.not_valid_username_error)
    }

    @Test
    fun `given polish characters username when validateUsername then return proper message`() {
        val polishCharacterString = "śĆĄŚĘ"
        whenever(context.getString(R.string.not_valid_username_error)).doReturn("Enter a valid name")

        val result = registerClass.validateUsername(polishCharacterString)

        result `should be` "Enter a valid name"
    }

    @Test
    fun `given correct username when validateUsername then do not request text from resources`() {
        val goodUsername = "ALex123"
        whenever(context.getString(R.string.not_valid_username_error)).doReturn("Enter a valid name")

        registerClass.validateUsername(goodUsername)

        verify(context, never()).getString(R.string.not_valid_username_error)
    }

    @Test
    fun `given correct username when validateUsername then return null`() {
        val goodUsername = "ALex123"
        whenever(context.getString(R.string.not_valid_username_error)).doReturn("Enter a valid name")

        val result = registerClass.validateUsername(goodUsername)

        result `should be` null
    }
    @Test
    fun `given invalid pattern email when validateEmail then return proper message`() {
        val badPatternEmail = "sthNoAtsth.com"
        whenever(context.getString(R.string.not_valid_email_error)).doReturn("Enter a valid email address")

        val result = registerClass.validateEmail(badPatternEmail)

        result `should be` "Enter a valid email address"
    }

    @Test
    fun `given invalid pattern email when validateEmail then request text from resources by proper resource id`() {
        val badPatternEmail = "sthNoAtsth.com"
        whenever(context.getString(R.string.not_valid_email_error)).doReturn("Enter a valid email address")

        registerClass.validateEmail(badPatternEmail)

        verify(context).getString(R.string.not_valid_email_error)
    }

    @Test
    fun `given empty email when validateEmail then return proper message`() {
        val emptyEmail = ""
        whenever(context.getString(R.string.not_valid_email_error)).doReturn("Enter a valid email address")

        registerClass.validateEmail(emptyEmail)

        verify(context).getString(R.string.not_valid_email_error)
    }

    @Test
    fun `given empty email when validateEmail then request text from resources by proper resource id`() {
        val emptyEmail = ""
        whenever(context.getString(R.string.not_valid_email_error)).doReturn("Enter a valid email address")

        val result = registerClass.validateEmail(emptyEmail)

        result `should be` "Enter a valid email address"
    }

    @Test
    fun `given email with Big character after At symbol when validateEmail then return proper message`() {
        val bigAfterAt = "someEmail@BIG.com"
        whenever(context.getString(R.string.not_valid_email_error)).doReturn("Enter a valid email address")

        val result = registerClass.validateEmail(bigAfterAt)

        result `should be` "Enter a valid email address"
    }

    @Test
    fun `given email with Big character after At symbol when validateEmail then request text from resources by proper resource id`() {
        val bigAfterAt = "someEmail@BIG.com"
        whenever(context.getString(R.string.not_valid_email_error)).doReturn("Enter a valid email address")

        registerClass.validateEmail(bigAfterAt)

        verify(context).getString(R.string.not_valid_email_error)
    }

    @Test
    fun `given email with Big character after dot symbol when validateEmail then return proper message`() {
        val bigAfterDot = "someEmial@small.BIG"
        whenever(context.getString(R.string.not_valid_email_error)).doReturn("Enter a valid email address")

        val result = registerClass.validateEmail(bigAfterDot)

        result `should be` "Enter a valid email address"
    }

    @Test
    fun `given email with Big character after dot symbol when validateEmail then request text from resources by proper resource id`() {
        val bigAfterDot = "someEmial@small.BIG"
        whenever(context.getString(R.string.not_valid_email_error)).doReturn("Enter a valid email address")

        registerClass.validateEmail(bigAfterDot)

        verify(context).getString(R.string.not_valid_email_error)
    }

    // Happy_path
    @Test
    fun `given correct email when validateEmail then return null`() {
        val correctEmail = "AlexEmail@patronage.com"
        whenever(context.getString(R.string.not_valid_email_error)).doReturn("Enter a valid email address")

        val result = registerClass.validateEmail(correctEmail)

        result `should be` null
    }

    @Test
    fun `given correct email when validateEmail then do not request text from resources`() {
        val correctEmail = "AlexEmail@patronage.com"
        whenever(context.getString(R.string.not_valid_email_error)).doReturn("Enter a valid email address")

        registerClass.validateEmail(correctEmail)

        verify(context, never()).getString(R.string.not_valid_email_error)
    }

    @Test
    fun `given password with no letters when validatePassword then return proper message`() {
        val noLetterPassword = "05564@@#$%"
        whenever(context.getString(R.string.not_valid_password_error)).doReturn("Enter a valid password")

        val result = registerClass.validatePassword(noLetterPassword)

        result `should be` "Enter a valid password"
    }

    @Test
    fun `given password with no letters when validatePassword then request text from resources by proper resource id`() {
        val noLetterPassword = "05564@@#$%"
        whenever(context.getString(R.string.not_valid_password_error)).doReturn("Enter a valid password")

        registerClass.validatePassword(noLetterPassword)

        verify(context).getString(R.string.not_valid_password_error)
    }

    @Test
    fun `given password with no decimals when validatePassword then return proper message`() {
        val noDecimalPassword = "ALex@@@&^%"
        whenever(context.getString(R.string.not_valid_password_error)).doReturn("Enter a valid password")

        val result = registerClass.validatePassword(noDecimalPassword)

        result `should be` "Enter a valid password"
    }

    @Test
    fun `given password with no decimals when validatePassword then then request text from resources by proper resource id`() {
        val noDecimalPassword = "ALex@@@&^%"
        whenever(context.getString(R.string.not_valid_password_error)).doReturn("Enter a valid password")

        registerClass.validatePassword(noDecimalPassword)

        verify(context).getString(R.string.not_valid_password_error)
    }

    @Test
    fun `given password with no special characters when validatePassword then return proper message`() {
        val noSpecialPassword = "ALex123"
        whenever(context.getString(R.string.not_valid_password_error)).doReturn("Enter a valid password")

        val result = registerClass.validatePassword(noSpecialPassword)

        result `should be` "Enter a valid password"
    }

    @Test
    fun `given password with no special characters when validatePassword then request text from resources by proper resource id`() {
        val noSpecialPassword = "ALex123"
        whenever(context.getString(R.string.not_valid_password_error)).doReturn("Enter a valid password")

        registerClass.validatePassword(noSpecialPassword)

        verify(context).getString(R.string.not_valid_password_error)
    }

    @Test
    fun `given empty password when validatePassword then return proper message`() {
        val emptyPassword = ""
        whenever(context.getString(R.string.not_valid_password_error)).doReturn("Enter a valid password")

        val result = registerClass.validatePassword(emptyPassword)

        result `should be` "Enter a valid password"
    }

    @Test
    fun `given empty password when validatePassword then request text from resources by proper resource id`() {
        val emptyPassword = ""
        whenever(context.getString(R.string.not_valid_password_error)).doReturn("Enter a valid password")

        registerClass.validatePassword(emptyPassword)

        verify(context).getString(R.string.not_valid_password_error)
    }

    @Test
    fun `given correct password when validatePassword then return null`() {
        val correctPassword = "IamaGoodPAsswordś123@123$"
        whenever(context.getString(R.string.not_valid_password_error)).doReturn("Enter a valid password")

        val result = registerClass.validatePassword(correctPassword)

        result `should be` null
    }

    @Test
    fun `given correct password when validatePassword then do not request text from resources`() {
        val correctPassword = "IamaGoodPAsswordś123@123$"
        whenever(context.getString(R.string.not_valid_password_error)).doReturn("Enter a valid password")

        registerClass.validatePassword(correctPassword)

        verify(context, never()).getString(R.string.not_valid_password_error)
    }
}