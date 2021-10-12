package com.example.a7minworkout.activity.const

import com.example.a7minworkout.R
import com.example.a7minworkout.activity.model.User


class Constants {
    companion object {
        fun AllLists(): ArrayList<User> {
            var exerSizeList = ArrayList<User>()

            val jumpingJack = User("Jumping Jacks", R.raw.jumping_jack1, false, false)
            exerSizeList.add(jumpingJack)

            val jumping = User("Jumping", R.raw.jumping_jacks, false, false)
            exerSizeList.add(jumping)

            val shoulder = User("Shoulder Stretch", R.raw.shoulder_stretch, false, false)
            exerSizeList.add(shoulder)

            val squat = User("Squat Kick", R.raw.squat_kick, false, false)
            exerSizeList.add(squat)

            val armPushUp = User("Arm Push up", R.raw.arm_push_up, false, false)
            exerSizeList.add(armPushUp)

            val pushUp = User("Push up", R.raw.push_ups, false, false)
            exerSizeList.add(pushUp)

            val punch = User("Punches", R.raw.punches, false, false)
            exerSizeList.add(punch)

            val plank = User("Plank Exercise", R.raw.plank_excercise, false, false)
            exerSizeList.add(plank)

            val reverse = User("Reverse Crunches", R.raw.reverse_crunches, false, false)
            exerSizeList.add(reverse)

            val inchworm = User("Inchworm", R.raw.inchworm, false, false)
            exerSizeList.add(inchworm)

            val absCircle = User("Abs Circle", R.raw.abs_circles, false, false)
            exerSizeList.add(absCircle)


            return exerSizeList
        }

        fun getWomens(): ArrayList<User> {
            var exerSizeList1 = ArrayList<User>()
            val Lunges = User("Jumping Lunges", R.raw.jumping_lunges, false, false)
            exerSizeList1.add(Lunges)
            val chair = User("Jump Right", R.raw.split_squat_jump_right, false, false)
            exerSizeList1.add(chair)
            val high = User("Side hip abduction", R.raw.side_hip_abduction, false, false)
            exerSizeList1.add(high)
            val sit = User("Bridge", R.raw.bridge, false, false)
            exerSizeList1.add(sit)

            val jumpingJack = User("Cobra", R.raw.cobra, false, false)
            exerSizeList1.add(jumpingJack)

            val jumping = User("Dead bug exercise", R.raw.deadbug_exercise, false, false)
            exerSizeList1.add(jumping)

            val shoulder = User("Open books", R.raw.open_books, false, false)
            exerSizeList1.add(shoulder)

            val squat = User("Spiderman push up", R.raw.spiderman_push_up, false, false)
            exerSizeList1.add(squat)

            return exerSizeList1
        }

        fun onlyAbs(): ArrayList<User> {
            var list = ArrayList<User>()
            val reverse = User("Reverse Crunches", R.raw.reverse_crunches, false, false)
            list.add(reverse)

            val inchworm = User("Inchworm", R.raw.inchworm, false, false)
            list.add(inchworm)

            val absCircle = User("Abs Circle", R.raw.abs_circles, false, false)
            list.add(absCircle)
            return list
        }

        fun AllExercises(): ArrayList<User> {
            var exerSizeList2 = ArrayList<User>()

            val jumpingJack = User("Jumping Jacks", R.raw.jumping_jack1, false, false)
            exerSizeList2.add(jumpingJack)

            val jumping = User("Jumping", R.raw.jumping_jacks, false, false)
            exerSizeList2.add(jumping)

            val shoulder = User("Shoulder Stretch", R.raw.shoulder_stretch, false, false)
            exerSizeList2.add(shoulder)

            val squat = User("Squat Kick", R.raw.squat_kick, false, false)
            exerSizeList2.add(squat)

            val armPushUp = User("Arm Push up", R.raw.arm_push_up, false, false)
            exerSizeList2.add(armPushUp)

            val pushUp = User("Push up", R.raw.push_ups, false, false)
            exerSizeList2.add(pushUp)

            val punch = User("Punches", R.raw.punches, false, false)
            exerSizeList2.add(punch)

            val plank = User("Plank Exercise", R.raw.plank_excercise, false, false)
            exerSizeList2.add(plank)

            val reverse = User("Reverse Crunches", R.raw.reverse_crunches, false, false)
            exerSizeList2.add(reverse)

            val inchworm = User("Inchworm", R.raw.inchworm, false, false)
            exerSizeList2.add(inchworm)

            val absCircle = User("Abs Circle", R.raw.abs_circles, false, false)
            exerSizeList2.add(absCircle)

            val Lunges = User("Jumping Lunges", R.raw.jumping_lunges, false, false)
            exerSizeList2.add(Lunges)
            val chair = User("Jump Right", R.raw.split_squat_jump_right, false, false)
            exerSizeList2.add(chair)
            val high = User("Side hip abduction", R.raw.side_hip_abduction, false, false)
            exerSizeList2.add(high)
            val sit = User("Bridge", R.raw.bridge, false, false)
            exerSizeList2.add(sit)

            val cobra = User("Cobra", R.raw.cobra, false, false)
            exerSizeList2.add(cobra)

            val Deadbug = User("Dead bug exercise", R.raw.deadbug_exercise, false, false)
            exerSizeList2.add(Deadbug)

            val openbook = User("Open books", R.raw.open_books, false, false)
            exerSizeList2.add(openbook)

            val spiderman = User("Spiderman push up", R.raw.spiderman_push_up, false, false)
            exerSizeList2.add(spiderman)

            return exerSizeList2
        }
    }

}