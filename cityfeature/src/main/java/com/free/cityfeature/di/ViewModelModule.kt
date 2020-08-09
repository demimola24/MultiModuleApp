package com.mintfintech.app.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mintfintech.app.ui.auth.alternateregistration.updatephone.PhoneValidationViewModel
import com.mintfintech.app.ui.auth.profile.identity.IdentityInformationViewModel
import com.mintfintech.app.ui.auth.profile.physical.PhysicalVerificationViewModel
import com.mintfintech.app.ui.auth.login.LoginViewModel
import com.mintfintech.app.ui.auth.profile.createpassword.CreatePasswordViewModel
import com.mintfintech.app.ui.auth.profile.personal.PersonalInformationViewModel
import com.mintfintech.app.ui.auth.profile.termscondition.TermsAndConditionViewModel
import com.mintfintech.app.ui.auth.recovery.deviceregistration.accountinfo.DeviceRegistrationViewModel
import com.mintfintech.app.ui.auth.recovery.deviceregistration.confirmdevicechange.ConfirmDeviceChangeViewModel
import com.mintfintech.app.ui.auth.recovery.resetpassword.stagefour.ResetPasswordViewModel
import com.mintfintech.app.ui.auth.recovery.resetpassword.stageone.BasicDetailsViewModel
import com.mintfintech.app.ui.auth.recovery.resetpassword.stagethree.ConfirmSecurityQuestionViewModel
import com.mintfintech.app.ui.auth.recovery.resetpassword.stagetwo.VerifyCodeSentViewModel
import com.mintfintech.app.ui.auth.recovery.resetsecuritydetails.stageone.ResetCodeViewModel
import com.mintfintech.app.ui.auth.recovery.resetsecuritydetails.stagethree.ResetSecurityPasswordViewModel
import com.mintfintech.app.ui.auth.register.RegisterViewModel
import com.mintfintech.app.ui.auth.userverification.AccountVerificationViewModel
import com.mintfintech.app.ui.base.viewmodel.SharedViewModel
import com.mintfintech.app.ui.bills.BillsPaymentViewModel
import com.mintfintech.app.ui.cards.CardViewModel
import com.mintfintech.app.ui.finance.moneymanager.MoneyManagerViewModel
import com.mintfintech.app.ui.finance.transactions.TransactionViewModel
import com.mintfintech.app.ui.fund.account.FundAccountViewModel
import com.mintfintech.app.ui.fund.amount.FundAmountViewModel
import com.mintfintech.app.ui.goal.creategoal.CreateSavingGoalViewModel
import com.mintfintech.app.ui.goal.creategoal.SavingSummaryViewModel
import com.mintfintech.app.ui.goal.fundgoal.FundSavingGoalViewModel
import com.mintfintech.app.ui.goal.viewgoal.GoalDetailViewModel
import com.mintfintech.app.ui.goal.withdraw.FundWithdrawalViewModel
import com.mintfintech.app.ui.home.HomeViewModel
import com.mintfintech.app.ui.notification.NotificationViewModel
import com.mintfintech.app.ui.receipt.ReceiptViewModel
import com.mintfintech.app.ui.settings.SettingsViewModel
import com.mintfintech.app.ui.settings.accountmgmt.AccountManagementViewModel
import com.mintfintech.app.ui.settings.accountmgmt.limit.LimitViewModel
import com.mintfintech.app.ui.settings.accountmgmt.pin.create.CreateOrUpdateTransactionPinViewModel
import com.mintfintech.app.ui.settings.accountmgmt.pin.reset.ResetPinViewModel
import com.mintfintech.app.ui.settings.accountmgmt.pin.reset.ValidateSecurityQuestionViewModel
import com.mintfintech.app.ui.settings.accountmgmt.security.password.ChangePasswordViewModel
import com.mintfintech.app.ui.settings.accountmgmt.security.question.SecurityQuestionViewModel
import com.mintfintech.app.ui.settings.help.HelpViewModel
import com.mintfintech.app.ui.settings.profile.editemploment.EditEmploymentViewModel
import com.mintfintech.app.ui.settings.profile.editidentity.EditIdentityViewModel
import com.mintfintech.app.ui.settings.profile.editpersonal.EditPersonalViewModel
import com.mintfintech.app.ui.transfer.completetransfer.transferdetails.TransferViewModel
import com.mintfintech.app.ui.transfer.verifyaccount.VerifyAccountViewModel
import com.mintfintech.app.ui.transfer.completetransfer.verifypin.TransactionPinVerificationViewModel
import com.mintfintech.app.ui.transfer.beneficiary.AddBeneficiaryViewModel
import com.mintfintech.app.viewmodel.MintViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TransferViewModel::class)
    abstract fun bindTransferViewModel(viewModel: TransferViewModel): ViewModel

}