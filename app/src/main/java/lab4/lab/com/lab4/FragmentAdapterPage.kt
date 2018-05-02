package lab4.lab.com.lab4

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import lab4.lab.com.lab4.pages.FragmentAdd
import lab4.lab.com.lab4.pages.FragmentDel
import lab4.lab.com.lab4.pages.FragmentShow
import lab4.lab.com.lab4.pages.FragmentUpdate


class FragmentAdapterPage(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> FragmentShow()
            1 -> FragmentAdd()
            2 -> FragmentDel()
            3 -> FragmentUpdate()
            else -> null
        }
    }

    override fun getCount(): Int {
        return NUM_ITEMS
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "FragmentShow"
            1 -> "FragmentAdd"
            2 -> "FragmentDel"
            3 -> "FragmentUpdate"
            else -> ""
        }
    }
    companion object {

        private const val NUM_ITEMS = 4
    }
}